InputStream instr;
t0 = java.lang.System.currentTimeMillis();
HttpResponse response = httpclient.execute(request);
rc=response.getStatusLine().getStatusCode();
instr=response.getEntity().getContent();
instr.skip(250*4096);
t1 = java.lang.System.currentTimeMillis();