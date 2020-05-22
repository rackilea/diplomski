int[][] tutorData = { // students per day (MTW) per tutor
                {25, 3, 0}, // Amy
                {14, 5, 12}, // John
                {33, 22, 10}, // Nick
                {0, 20, 5}}; // Maria

int numOfDays = tutorData[0].length; // number of days = number of "columns"
int numOfTutors = tutorData.length; // number of tutors = number of "rows"
int[] sumPerDay = new int [numOfDays]; // array to store total # of students per day
int[] sumPerTutor = new int[numOfTutors]; // array to store total # of students per tutor

for(int i=0; i<numOfDays; i++){
    for(int j=0; j<numOfTutors; j++){
        sumPerDay[i] += tutorData[j][i];
        sumPerTutor[j] += tutorData[j][i];
    }
}