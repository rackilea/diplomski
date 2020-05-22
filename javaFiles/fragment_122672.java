Date newDate = sourceDateFormatter.parse(newTime.getDate());
Date date;
int insert = 0;
do {
    date = sourceDateFormatter.parse(list.get(insert).getDate());
} while(date.compareTo(newDate) < 0 && ++insert < list.size());

list.add(insert, newTime);