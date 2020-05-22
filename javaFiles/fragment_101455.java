if (data.length >= 7)
{
    System.out.println(data[0] + " - " + data[6]);
    int changeId = Integer.parseInt(data[0]);
    int changeCv = Integer.parseInt(data[6]);
    changeData.put(changeId, changeCv);
}