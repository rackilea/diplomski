if (speed > dist) {
                destX = target.y - this.getX();
                destY = target.x - this.getY();

                destX = destX / dist;
                destY = destY / dist;

                double travelX = (destX * speed);
                double travelY = (destY * speed);

                this.setX((int)travelX);
                this.setY((int)travelY);
            } else {
                destX = destX / dist;
                destY = destY / dist;

                double travelX = (destX * speed);
                double travelY = (destY * speed);

                this.moveBy((float) travelX, (float)travelY);
            }