if (null != allergyArray && null != vitalsArray)
{
    for (int i = 0; i < allergyArray.length() && i < vitalsArray.length(); ++i)
    {
        object = new Response(); // POJO class
        object.setCap(allergyArray.getJSONObject(i).getString("Cap"));
        object.setRea(allergyArray.getJSONObject(i).getString("Rea"));
        object.setName(vitalsArray.getJSONObject(i).getString("Name"));
        object.setMedic(vitalsArray.getJSONObject(i).getString("Medic"));

        Data.add(object);
    }
}