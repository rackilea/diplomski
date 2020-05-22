class StepSerializer implements JsonSerializer<Step>
{
  public JsonElement serialize (Step src,
                                Type typeOfSrc,
                                JsonSerializationContext context)
    {
      Gson gson = new Gson ();
      /* Whenever Step is serialized,
      serialize the contained Data correctly.  */
      JsonObject step = new JsonObject ();
      step.add ("start_name", gson.toJsonTree (src.start_name);
      step.add ("end_name",   gson.toJsonTree (src.end_name);

      /* Notice how I'm digging 2 levels deep into 'data.' but adding
      JSON elements 1 level deep into 'step' itself.  */
      step.add ("duration",   gson.toJsonTree (src.data.duration);
      step.add ("distance",   gson.toJsonTree (src.data.distance);
      step.add ("location",   gson.toJsonTree (src.data.location);

      return step;
    }
}