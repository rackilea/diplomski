StringBuilder stringBuilder = new StringBuilder("");
for (Map.Entry<Integer, Integer> entry : mapOfSum.entrySet())
{
    stringBuilder.append("id=").append(entry.getKey()).append(" amount=").append(entry.getValue()).append(", ");
}

System.out.println(stringBuilder.toString());