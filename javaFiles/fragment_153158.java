class Foo{
    void setProperties(final ResultSet rs){
        // do stuff
    }
}

final class Bar extends Foo{
    @Override
    final void setProperties(final ResultSet rs){
        // do stuff
        super.setProperties(rs);
    }
}