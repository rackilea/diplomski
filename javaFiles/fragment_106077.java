Block root = new TenBlock();

Block child10 = root.get(9);

root.set(5, (new TenBlock()).set(2, new TenBlock()))
    .set(6, new TenBlock())