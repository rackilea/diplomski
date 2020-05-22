try {
    Socket socket = new Socket();
    // 1000 is the timeout
    socket.connect(new InetSocketAddress(IPADD, PORT), 1000);
    Toast.makeText(ipInfo.this,"Connected",Toast.LENGTH_SHORT).show();
    Intent inst = new Intent(ipInfo.this,homeActivity.class);
    inst.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(inst);
    finish();
} catch (IOException e)
    Toast.makeText(ipInfo.this,"Server is disconnected\nStart server in desktop",Toast.LENGTH_SHORT).show();
} catch (Exception e) {
    Toast.makeText(ipInfo.this,e.getMessage(),Toast.LENGTH_SHORT).show();
}