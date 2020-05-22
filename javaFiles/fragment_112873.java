for(Vector3D point : points)
        {
            point = Vector3D.mult(point, scale);
            point = Vector3D.mult(point, rotate_x);
            point = Vector3D.mult(point, rotate_y);
            point = Vector3D.mult(point, rotate_z);
            point = Vector3D.mult(point, translate);
            point = Vector3D.mult(point, eye);

            if(point.z() != 0)
            {
                point.setX(point.x()/(-point.z()));
                point.setY(point.y()/(-point.z()));
            }

            checkMinMax(point);
        }