foundValue = runnersTime2017[0];
for (int i = 0; i < runnersTime2017.length; ++i) {
    for (int j = 0; j < runnersTime2018.length; ++j) {
        if (runnersTime2018[j] > runnersTime2017[i]) {
            foundValue = runnersTime2018[j];
         }
    }
}
return foundValue;