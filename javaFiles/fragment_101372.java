availableCPUS = 0;
Iterator<JobRequest> it = q.iterator();
while (it.hasNext()) {
    temp = it.next();
    if (temp != null) {
        availableCPUS += temp.getCores();
    }
}