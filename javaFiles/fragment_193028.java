for (Student std:list) {
  if (std.studentId == targetId) {
    list.remove(std);
    break; //since you've removed target, you can exit the loop
  }
}