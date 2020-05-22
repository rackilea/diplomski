String valueImage; // Get url fro SQLite

Glide
     .With(this)
     .Load(Uri.parse(valueImage))
     .Apply(RequestOptions.CircleCropTransform()).Into(imageView);