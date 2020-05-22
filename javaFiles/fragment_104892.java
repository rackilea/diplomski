IDataReader reader=GetTheDataReader(dayOfWeek);

while (reader.Read())
{
    file.Write(formatRow(reader));
}