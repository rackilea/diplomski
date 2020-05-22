ResultSet rs = st.executeQuery(sum); //rs should have 1 row, 1 column
if (rs.next())
{
    double d = rs.getDouble(1);
    ...
}
else
    // Failed to get result, do something useful here