function SuperMatrix() {
  this.ranks = [].slice.call(arguments);
  this.rankCount = this.ranks.length;

  this.arraySize = 
    this.ranks.reduce(function(a,b) { return a*b; }, 1);

  this.dimensionSize = [];

  this.dimensionSize[this.rankCount-1] = 1;
  for (var i = this.rankCount-2; i >= 0; i -= 1) {
    this.dimensionSize[i] = 
      this.dimensionSize[i+1]*this.ranks[i+1];
  }

  this.array = new Array(this.arraySize);
}

SuperMatrix.prototype._index = function() {

  var indexes = [].slice.call(arguments);
  if (indexes.length !== this.rankCount)
     throw new Error('invalid number of indexes');

  var index = 0;
  for (var i = 0; i < this.rankCount; i += 1) {
    index += indexes[i]*this.dimensionSize[i];
  }

  if (index < 0 || index >= this.arraySize)
     throw new Error('invalid index: ' + indexes.join(', '));

  return index;
}

SuperMatrix.prototype.get = function() {
  var index = this._index.apply(this, arguments);
  return this.array[index];
};

SuperMatrix.prototype.set = function(value) {
  var indexes = [].slice.call(arguments, 1);

  var index = this._index.apply(this, indexes);
  this.array[index] = value;

  return value;
};


var foo = new SuperMatrix(2,3,5);

for (var i = 0; i < 2; i+=1) {
  for (var j =0; j < 3; j+=1) {
    for (var k = 0; k < 5; k+= 1) {
      foo.set([i,j,k].join(':'), i,j,k);
    }
  }
}

for (var i = 0; i < 2; i+=1) {
  for (var j =0; j < 3; j+=1) {
    for (var k = 0; k < 5; k+= 1) {
      console.log(foo.get(i,j,k));
    }
  }
}


console.log(foo);