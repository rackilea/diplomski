int min = age[0];
int minindex = 0;
for(int i = 1; i < age.length; i++) {
  if (age[i] < min) {
    minindex = i;
    min = age[i];
  }
}

System.out.println("Name of youngest athlete:" +
    names[minindex] + "\n age:" + min + "\n points:" +
    points[minindex]);