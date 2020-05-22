public class StudentMessageModel {

private String studentUsername;
private String studentName;
private String studentMessage;
private String generatedChatID;
private long studentTime;

public StudentMessageModel(String studentUsername, String studentName, String studentMessage, String generatedChatID) {
    this.studentUsername = studentUsername;
    this.studentName = studentName;
    this.studentMessage = studentMessage;
    this.generatedChatID = generatedChatID;

    studentTime = new Date().getTime();
}

public StudentMessageModel(){}