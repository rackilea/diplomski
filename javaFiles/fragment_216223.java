try {
    ...
    zipOutputStream.flush();
    zipOutputStream.close();
} catch (Exception e) {
    halt(405,"server error");
}
return responce.raw();