Iterator<PatientProcedures> iterator = list.iterator();

while (iterator.hasNext())
{
    PatientProcedures s = iterator.next();

    if (wantToRemove)
    {
        iterator.remove();
    }
}