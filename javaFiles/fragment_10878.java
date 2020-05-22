Model knight = assets.get(...);
NodePart part1 = knight.nodes.get(0).parts.get(0);
NodePart part2 = new NodePart(part1.meshPart, new Material());
knight.nodes.get(0).parts.add(part2);
part1.material.set(TextureAttribute.createDiffuse(texture1));
part2.material.set(TextureAttribute.createDiffuse(texture2));