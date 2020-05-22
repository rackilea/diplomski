package play.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SchoolsHandler handler = new SchoolsHandler();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse("schools.xml", handler);
            System.out.println("Number of read schools: " + handler.getSchools().size());
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}

class SchoolsHandler extends DefaultHandler {
    private static final String TAG_SCHOOLS = "Schools";
    private static final String TAG_SCHOOL = "School";
    private static final String TAG_STUDENT = "Student";
    private static final String TAG_ID = "ID";
    private static final String TAG_NAME = "Name";

    private final Stack<String> tagsStack = new Stack<String>();
    private final StringBuilder tempVal = new StringBuilder();

    private List<School> schools;
    private School school;
    private Student student;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        pushTag(qName);
        tempVal.setLength(0);
        if (TAG_SCHOOLS.equalsIgnoreCase(qName)) {
            schools = new ArrayList<School>();
        } else if (TAG_SCHOOL.equalsIgnoreCase(qName)) {
            school = new School();
        } else if (TAG_STUDENT.equalsIgnoreCase(qName)) {
            student = new Student();
        }
    }

    public void characters(char ch[], int start, int length) {
        tempVal.append(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) {
        String tag = peekTag();
        if (!qName.equals(tag)) {
            throw new InternalError();
        }

        popTag();
        String parentTag = peekTag();

        if (TAG_ID.equalsIgnoreCase(tag)) {
            int id = Integer.valueOf(tempVal.toString().trim());
            if (TAG_STUDENT.equalsIgnoreCase(parentTag)) {
                student.setId(id);
            } else if (TAG_SCHOOL.equalsIgnoreCase(parentTag)) {
                school.setId(id);
            }
        } else if (TAG_NAME.equalsIgnoreCase(tag)) {
            String name = tempVal.toString().trim();
            if (TAG_STUDENT.equalsIgnoreCase(parentTag)) {
                student.setName(name);
            } else if (TAG_SCHOOL.equalsIgnoreCase(parentTag)) {
                school.setName(name);
            }
        } else if (TAG_STUDENT.equalsIgnoreCase(tag)) {
            school.addStudent(student);
        } else if (TAG_SCHOOL.equalsIgnoreCase(tag)) {
            schools.add(school);
        }
    }

    public void startDocument() {
        pushTag("");
    }

    public List<School> getSchools() {
        return schools;
    }

    private void pushTag(String tag) {
        tagsStack.push(tag);
    }

    private String popTag() {
        return tagsStack.pop();
    }

    private String peekTag() {
        return tagsStack.peek();
    }
}

class School {
    private int id;
    private String name;
    private List<Student> students = new ArrayList<Student>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Student {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}