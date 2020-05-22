sorter = new Comparator<Decal>() {
        @Override
        public int compare (Decal o1, Decal o2) {
            float dist1 = camera.position.dst(o1.position);
            float dist2 = camera.position.dst(o2.position);
            float diff = dist2 - dist1;
            if (o1 instanceof MyDecal && o2 instanceof MyDecal && Math.abs(diff) < 0.001f)
                return (int)Math.signum(((MyDecal)o2).planePosition - ((MyDecal)o1).planePosition);
            return (int)Math.signum(diff);
        }
    }