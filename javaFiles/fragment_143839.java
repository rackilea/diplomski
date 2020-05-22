// reads a file and returns a array of employees found in the file
public Employee[] readEmployeeFile(String loc){
    BufferedReader read = new BufferedReader(new FileReader(loc)); // creating reader
    ArrayList<Employee> people = new ArrayList<Employee>(); // arraylist to store values of employees   

    // read all the lines in the file
    String line = "";
    while ((line=read.readLine())!=null){
        people.add(getEmployeeFromLine(line));
    }

    // close the reader
    read.close();

    // convert arraylist to array
    Employee[] returnvalues = new Employee[people];
    for (int q = 0; q < returnvalues.length; q++){
        returnvalues[q] = people.get(q);
    }

    return people;
}

// reads each individual line for the file
public Employee getEmployeeFromLine(String line){
    // format: date + job + name(contains 1 space) + monthly earnings + salesperson:annual sales | executive:stock price

    Employee returnvalue = null; // this is what we will return

    String[] values = line.split(" "); // the txt file seems to split up the values by a space so we split up the line by spaces

    // get all the values from the line
    Integer date = Integer.parseInt(values[0]); // date is the first value
    String position = values[1];
    String name = value[2]+values[3]; // we need both because there is a space in between the last name and first
    double monearns = Double.parseDouble(values[4]);

    double lastvalue;
    if (position.equals("Salesman") || position.equals("Executive")){ // only set the value if it exists otherwise we will get a index out of bounds exception
        lastvalue = values[5];
    }

    // you can structure the constructors how ever you would like - currently there is no value for date in the employee class
    if (position.equals("Employee")){
        returnvalue = new Employee(name, monearns, date);
    }
    else if (position.equals("Salesman")){
        returnvalue = new Salesman(name, monearns, date, lastvalue);
    }
    else if (position.equals("Executive")){
        returnvalue = new Executive(name, monearns, date, lastvalue);
    }
    return returnvalue;
}

public static void main(String[] args){
    Employee[] employees = readEmployeeFile("file.txt"); // if the file location needs to be user input I recommend just using a scanner

    // print out data
}