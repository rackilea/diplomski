int count = 0;
int stop = 1;
for (Steps step : beanList) {
    if(count != stop){
        System.out.println(step);
    }
    count++;
}