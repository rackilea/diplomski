float[] fl1 = new float[item.title.length()];
getPaint().getTextWidths(item.title, fl1);

float[] fl2 = new float[item.roomId.length()];
getPaint().getTextWidths(item.roomId, fl2);

float[] fl3 = new float[item.teacher.length() + item.classes.length() + 1];
getPaint().getTextWidths(item.teacher + " " + item.classes, fl3);

float differenceInWidth = sumUpTheArray(fl3) 
                          - sumUpTheArray(fl1) 
                          - sumUpTheArray(fl2);

float fSpaceArray[] = new float[1];

getPaint().getTextWidths(" ", fSpaceArray);

int numOfSpaces = (int) (differenceInWidth / fSpaceArray[0]);

char[] spaceCharArr = new char[numOfSpaces];

Arrays.fill(spaceCharArr, ' ');

setText(item.title + String.valueOf(spaceCharArr) + item.roomId + "\n" 
                            + item.teacher + " " + item.classes);