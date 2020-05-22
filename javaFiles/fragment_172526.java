public boolean collides(Wizard wizard) {
    if (Intersector.overlaps(wizard.getBoundingRectangle(), barUp)
            || Intersector.overlaps(wizard.getBoundingRectangle(), barDown)) {
        if (GameRenderer.InvulnerabilityActive) {
            GameRenderer.InvulnerabilityActivePending=false;
            return false;
        } else {
            return true;
        }
    } else {
        GameRenderer.InvulnerabilityActive=GameRenderer.InvulnerabilityActivePending;
        return false;
    }
}