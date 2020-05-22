public static void GirlsDiverse() {
    resetGirlRooms();
    Randomize(Girls);
    for (int srtF1 = 0; srtF1 < room1Arr.length; srtF1++) {
        done = false;
        newMove = room1Arr[srtF1];
        //if()
        {
            while (!done) {
                newMove.rndRoom(); //sets random number from 1 to 3
                if (newMove.getPrevRoom() == 1) {
                    {
                        if (newMove.getCurRoom() == 1 && !room1.isFull() && room1.getFromRoom1or4() < 2) {
                            room1.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 2 && !room2.isFull() && room2.getFromRoom1or4() < 2) {
                            room2.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 3 && !room3.isFull() && room3.getFromRoom1or4() < 2) {
                            room3.add(newMove);
                            done = true;
                        }
                    }
                }
            }
        }
    }
    for (int srtF2 = 0; srtF2 < room2Arr.length - 1; srtF2++) {
        done = false;
        newMove = room2Arr[srtF2];
        //if()
        {
            while (!done) {
                newMove.rndRoom(); //sets random number from 1 to 3
                if (newMove.getPrevRoom() == 2) {
                    {
                        if (newMove.getCurRoom() == 1 && !room1.isFull() && room1.getFromRoom2or5() < 2) {
                            room1.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 2 && !room2.isFull() && room2.getFromRoom2or5() < 2) {
                            room2.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 3 && !room3.isFull() && room3.getFromRoom2or5() < 2) {
                            room3.add(newMove);
                            done = true;
                        }
                    }
                }
            }
        }
    }
    for (int srtF3 = 0; srtF3 < room3Arr.length - 1; srtF3++) {
        done = false;
        newMove = room3Arr[srtF3];
        //if()
        {
            while (!done) {
                newMove.rndRoom(); //sets random number from 1 to 3
                if (newMove.getPrevRoom() == 3) {
                    {
                        if (newMove.getCurRoom() == 1 && !room1.isFull() && room1.getFromRoom3or6() < 2) {
                            room1.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 2 && !room2.isFull() && room2.getFromRoom3or6() < 2) {
                            room2.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 3 && !room3.isFull() && room3.getFromRoom3or6() < 2) {
                            room3.add(newMove);
                            done = true;
                        }
                    }
                }
            }
        }
    }

    for (int srtF2b = room2Arr.length-1; srtF2b < room2Arr.length; srtF2b++) {
        done = false;
        newMove = room2Arr[srtF2b];
        //if()
        {
            while (!done) {
                newMove.rndRoom(); //sets random number from 1 to 3
                if (newMove.getPrevRoom() == 2) {
                    {
                        if (newMove.getCurRoom() == 1 && !room1.isFull() && room1.getFromRoom2or5() < 3) {
                            room1.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 2 && !room2.isFull() && room2.getFromRoom2or5() < 3) {
                            room2.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 3 && !room3.isFull() && room3.getFromRoom2or5() < 3) {
                            room3.add(newMove);
                            done = true;
                        }
                    }
                }
            }
        }
    }
    for (int srtF3b = room3Arr.length - 1; srtF3b < room3Arr.length; srtF3b++) {
        done = false;
        newMove = room3Arr[srtF3b];
        //if()
        {
            while (!done) {
                newMove.rndRoom(); //sets random number from 1 to 3
                if (newMove.getPrevRoom() == 3) {
                    {
                        if (newMove.getCurRoom() == 1 && !room1.isFull() && room1.getFromRoom3or6() < 3) {
                            room1.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 2 && !room2.isFull() && room2.getFromRoom3or6() < 3) {
                            room2.add(newMove);
                            done = true;
                        } else if (newMove.getCurRoom() == 3 && !room3.isFull() && room3.getFromRoom3or6() < 3) {
                            room3.add(newMove);
                            done = true;
                        }
                    }
                }
            }
        }
    }
    room1.shuffleRoom();
    room2.shuffleRoom();
    room3.shuffleRoom();
}