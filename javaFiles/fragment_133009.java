double sum = 0;
for(Integer i : temp) {
    if(i > 40) {
        sum += i;
        count++;
    }
}

if(count != 0) { // avoid divide-by-zero error here
    System.out.println(sum / count);
}