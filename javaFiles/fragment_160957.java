function format(key) {
  if (key[0] >>> 7 === 0) {
    return key.toString('hex');
  }

  return '-' + new BN(key.toString('hex'), 16).notn(192).add(new BN(1)).toString(16);
}