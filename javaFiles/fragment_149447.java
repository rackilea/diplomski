function Gallery() {
  this.weight = null;
  this.height = null;
  this.colorCode = null;
  this.stockGallery = null;
};

var carCounter = 10;
var carGallery = new Array(carCounter);

carGallery[0] = new Gallery();
carGallery[0].weight = 1.2;
carGallery[0].height = 0.87;
carGallery[0].colorCode = 2
carGallery[0].stockGallery = 3;

carGallery[1] = new Gallery();
carGallery[1].weight = 2.2;
...