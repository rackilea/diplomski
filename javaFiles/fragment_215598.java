Field<String> value = field(name("A", "value"), String.class);
sql.dsl()
   .selectDistinct(value)
   .from(
        CAMPAIGN, 
        lateral(table("jsonb_array_elements_text({0})", CAMPAIGN.TAGS)).as("A"))
   .where(value.like("t%"))
   .fetch();