echo '<!--?xml version="1.0"?>-->
<!--DOCTYPE fontconfig SYSTEM "fonts.dtd">-->
<!-- ~/.fonts.conf for per-user font configuration -->
<fontconfig>' > ~/.fonts.conf
# here fc-list will produce small warning about bad ~/.fonts.conf
# don't worry about it
fc-list | grep -vi EXCLUDE_FONT | while read FONT ; do 
echo "<rejectfont><pattern><patelt name=\"family\"><string>${FONT%%:*}</string></patelt></pattern></rejectfont>" >> ~/.fonts.conf ; 
done
echo "</fontconfig>" >> ~/.fonts.conf