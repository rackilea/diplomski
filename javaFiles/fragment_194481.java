Document doc = do you parsing here...

Element pending = doc.select("table td:eq(0)").first();
Element nextDate = doc.select("table td:eq(0)").get(9);
Element date = doc.select("table td:eq(1)").last();

System.out.println(pending.text() + "\n" + nextDate.text() + "\n" + date.text());