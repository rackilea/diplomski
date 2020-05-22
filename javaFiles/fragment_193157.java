DiaryBook currentUserDiary = null;

try {
    aListOb.loadExistingDiaries(myAccountName);
    currentUserDiary = aListOb.getExistingDiaries(myAccountName);

    for (int i = 0; i < currentUserDiary.size(); i++) {
        System.out.println(currentUserDiary.get(i));
    }

} catch (IOException e) {

}

if(currentUserDiary != null){
    //Do your business
}