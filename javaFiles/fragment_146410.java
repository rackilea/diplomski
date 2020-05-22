String[] sub = request.getParameterValues("subject");
int i = 0;
while (i < sub.length) {
    sub[i] = m.getSubj();
    mgr.insertSubject(m);
    out.println("Successful registered subject");
}