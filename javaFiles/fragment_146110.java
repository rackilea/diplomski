// Create a Canvas3D using the preferred configuration
    Canvas3D canvas3d = new Canvas3D(config)
    {
        private static final long serialVersionUID = 7144426579917281131L;

        public void postRender()
        {
            this.getGraphics2D().setColor(Color.white);
            this.getGraphics2D().drawString("Heads Up Display (HUD) Works!",100,100);
            this.getGraphics2D().flush(false);
        }
    };