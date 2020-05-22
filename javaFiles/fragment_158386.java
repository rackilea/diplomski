for(int x = 0; x < 5; x++) 
{ 
    if(name.equalsIgnoreCase(empName[x]) || job.equalsIgnoreCase(jobName[x]))
    { 
        errorortitle.setText(jobTitle[x]);

    } 
    if(!(name.equalsIgnoreCase(empName[x]) || job.equalsIgnoreCase(jobName[x])))
    { 
        errorortitle.setText("Employee not found");

    } 
}