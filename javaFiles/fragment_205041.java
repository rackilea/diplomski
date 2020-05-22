css_list = ["styles"]
css_path = #{current_path}/css
# run ("cd #{css_path}") // Obsolete, it would only change the directory for this line!
css_list.each do |css|
  run "cd #{css_path} && #{compressor} --type css #{css}.css -o #{css}.min.css"
  run "cd #{css_path} && gzip -c #{css}.min.css >#{js}.min.css.gz"
end