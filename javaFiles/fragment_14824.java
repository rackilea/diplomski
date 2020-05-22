Employee emp = (Employee)obj;
if(age==emp.age)
    return 0;
else if (age < emp.age)
    return -1;
else
    return 1;