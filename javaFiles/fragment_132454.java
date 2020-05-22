int count = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0;

for (int i = 0; i < 3; i++) {
System.out.println("Enter the age of the family member : ");
int age = klavye.nextInt();

if (age >= 0 && age <= 3)
    count++;
else if(age >=4 && age <= 12)
  count1++;
else if (age >= 13 && age <= 30)
  count2++;
else if (age >= 31 && age <= 49)
  count3++;
else if (age >=50 && age <= 120)
  count4++;
}
System.out.println(count+" "+ count3);