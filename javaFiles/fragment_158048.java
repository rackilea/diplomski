# create palette
greyScale <- colorRampPalette(c("black","white"))

# function to draw shape
plotHeart <- function(r, col){
  t <- seq(0,2*pi,length.out=100)
  x <- r*sin(t)^3
  y <- (13*r/16)*cos(t) - (5*r/16)*cos(2*t) - (2*r/16)*cos(3*t) - (r/16)*cos(4*t)
  polygon(x,y,col=col,border=NA)
}



# create new plot canvas
plot.new()
# limits are approximate here
plot.window(xlim=c(-16,16),ylim=c(-16,13))

# use mapply to loop
mapply(plotHeart,seq(16,0,length.out=100),greyScale(100))