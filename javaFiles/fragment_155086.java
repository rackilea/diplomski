private void calculate() {
        this.range = niceNum(maxPoint - minPoint, false);
        this.tickSpacing = niceNum(range / (maxTicks - 1), true);
        this.niceMin =
            Math.floor(minPoint / tickSpacing) * tickSpacing;
        this.niceMax = this.niceMin + tickSpacing * (maxticks - 1); // Always display maxticks
    }