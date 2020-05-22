public boolean collides(Wizard wizard) {
    if (Intersector.overlaps(wizard.getBoundingRectangle(), barUp)
            || Intersector.overlaps(wizard.getBoundingRectangle(), barDown)) {
        if (GameRenderer.InvulnerabilityActive) {
            GameRenderer.InvulnerabilityActive=false;
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}