public void sampleMethod(final Activity cont)
{
Intent intent = new Intent(cont, XYZ.class);
        cont.finish();
        cont.startActivity(intent);
}