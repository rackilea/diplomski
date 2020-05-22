List<HolderAnswer> newList = new ArrayList<HolderAnswer>();

int loop = 0;
int offset = (listAnswers.size() + 1) / 2;

while (newList.size() < listAnswers.size()) {
    newList.add(listAnswers.get(loop);
    if (newList.size() < listAnswers.size()) {
        newList.add(listAnswers.get(loop + offset);
    }
    loop += 1;
}