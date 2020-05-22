width_diff  = preferredImageSize.width  - availableImageSize.width
height_diff = preferredImageSize.height - availableImageSize.height
if (width_diff > 0) width_penalty = upscale_penalty   * width_diff
               else width_penalty = downscale_penalty * width_diff
if (height_diff > 0) height_penalty = upscale_penalty   * height_diff
                else height_penalty = downscale_penalty * height_diff
aspect_penalty = ((preferredImageSize.width / preferredImageSize.height) - 
                  (availableImageSize.width / availableImageSize.height)) * stretch_penalty;
total_penalty = width_penalty + height_penalty + aspect_penalty;