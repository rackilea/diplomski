public class Vector3D {

    public double x;
    public double y;
    public double z;

    public static final Vector3D NAN_VEC = new Vector3D(Double.NaN, Double.NaN, Double.NaN);
    public static final Vector3D NULL_VEC = new Vector3D(0, 0, 0);

    public enum Axis {
        X, Y, Z;
    }

    public Vector3D() {

    }

    /**
     * Crate a new Vector2D with x and y components.
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D(double... val) {
        x = val[0];
        y = val[1];
        z = val[2];
    }

    /**
     * Create a Vector3D by two angles (in degree).
     * 
     * The first angle is in XY direction. The second angle is the Z direction.
     * 
     * An angle (XY) of 0° results in (x, y) = (1, 0); 90° in (x, y) = (0, 1); ... An angle (Z) of 0° results in (x, y, z) = (x, y, 0); 90° in (x, y,
     * z) = (x, y, 1); -90° in (x, y, z) = (x, y, -1)
     * 
     * The resulting vector has a length of 1.
     * 
     * @param angleXY
     *        The angle of the new vector (in degree) for the XY direction (from 0 to 360).
     * 
     * @param angleZ
     *        The angle of the new vector (in degree) for the Z direction (from -90 to 90).
     */
    public Vector3D(double angleXY, double angleZ) {
        x = Math.cos(angleXY * Math.PI / 180) * Math.cos(angleZ * Math.PI / 180);
        y = Math.sin(angleXY * Math.PI / 180) * Math.cos(angleZ * Math.PI / 180);
        z = Math.sin(angleZ * Math.PI / 180);
        double len = length();
        x /= len;
        y /= len;
        z /= len;
    }

    private Vector3D(Vector3D clone) {
        this.x = clone.x;
        this.y = clone.y;
    }

    @Override
    public Vector3D clone() {
        return new Vector3D(this);
    }

    @Override
    public String toString() {
        return "Vector3D[x: " + x + " y: " + y + " z:" + z + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector3D) {
            Vector3D v = (Vector3D) obj;
            return Math.abs(x - v.x) < 1e-8 && Math.abs(y - v.y) < 1e-8 && Math.abs(z - v.z) < 1e-8;
        }
        return false;
    }

    /**
     * Get this vector as 3D-Array.
     */
    public double[] asArray() {
        return new double[] {x, y, z};
    }

    /**
     * The (euclidean) length of the Vector.
     */
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }
    /**
     * The length of this vector in a given norm.
     * 
     * @param norm
     *        The norm of the vector length.
     * 
     * @return The length of this vector in the given norm.
     */
    public double length(int norm) {
        if (norm == Integer.MAX_VALUE) {
            return Math.max(Math.max(x, y), z);
        }
        return Math.pow(Math.pow(x, norm) + Math.pow(y, norm) + Math.pow(z, norm), 1.0 / norm);
    }

    /**
     * Rotate this vector an angle (in degrees) around an axis resulting in a new Vector that is returned.
     * 
     * @param degrees
     *        The angle to return the vector.
     * 
     * @param axis
     *        The axis around which the vector is rotated.
     * 
     * @return The new created vector.
     */
    public Vector3D rotate(double degrees, Axis axis) {
        double cos = Math.cos(degrees * Math.PI / 180);
        double sin = Math.sin(degrees * Math.PI / 180);
        switch (axis) {
            case X:
                return new Vector3D(x, cos * y - sin * z, sin * y + cos * z);
            case Y:
                return new Vector3D(cos * x + sin * z, y, -sin * x + cos * z);
            case Z:
                return new Vector3D(cos * x - sin * y, sin * x + cos * y, z);
            default:
                return null;
        }
    }

    /**
     * Project the vector given as parameter on this vector.
     * 
     * @param vec
     *        The vector that is to be projected on this vector.
     * 
     * @return The projected vector.
     */
    public Vector3D project(Vector3D vec) {
        return mult(scalar(vec) / Math.pow(length(), 2));
    }

    /**
     * Add another Vector3D to this vector resulting in a new Vector that is returned.
     * 
     * @param vec
     *        The vector added to this vector.
     * 
     * @return The new created vector.
     */
    public Vector3D add(Vector3D vec) {
        return new Vector3D(x + vec.x, y + vec.y, z + vec.z);
    }
    /**
     * Subtract another Vector3D from this vector resulting in a new Vector that is returned.
     * 
     * @param vec
     *        The vector subtracted from this vector.
     * 
     * @return The new created vector.
     */
    public Vector3D sub(Vector3D vec) {
        return new Vector3D(x - vec.x, y - vec.y, z - vec.z);
    }
    /**
     * Multiply this vector with a scalar resulting in a new Vector that is returned.
     * 
     * @param scalar
     *        The scalar to multiply this vector with.
     * 
     * @return The new created vector.
     */
    public Vector3D mult(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    /**
     * Check whether this vector is linearly dependent to the parameter vector.
     * 
     * @param vec
     *        The checked vector.
     * 
     * @return True if the vectors are linearly dependent. False otherwise.
     */
    public boolean isLinearlyDependent(Vector3D vec) {
        double t1 = (x == 0 ? 0 : vec.x / x);
        double t2 = (y == 0 ? 0 : vec.y / y);
        double t3 = (z == 0 ? 0 : vec.z / z);
        return Math.abs(t1 - t2) < 1e-5 && Math.abs(t1 - t3) < 1e-5 && t1 != 0;//all parameters t are equal and != 0
    }

    /**
     * Calculate the scalar product of this vector and the parameter vector.
     * 
     * @param vec
     *        The vector to calculate the scalar with this vector.
     * 
     * @return The scalar of the vectors.
     */
    public double scalar(Vector3D vec) {
        return this.x * vec.x + this.y * vec.y + this.z * vec.z;
    }

    /**
     * Calculate the cross product of this vector with another vector (resulting vector = this X parameter vector)
     * 
     * @param vec
     *        The second vector for the cross product calculation.
     * 
     * @return The cross product vector of the two vectors.
     */
    public Vector3D cross(Vector3D vec) {
        return new Vector3D(y * vec.z - z * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
    }

    /**
     * Create a new vector with the same direction but a different length as this vector.
     * 
     * @param length
     *        The length of the new vector.
     * 
     * @return The new vector with a new length.
     */
    public Vector3D setLength(double length) {
        double len = length();
        return new Vector3D(x * length / len, y * length / len, z * length / len);
    }

    /**
     * Get the distance of this point's position vector to another point's position vector.
     * 
     * @param p
     *        The second point's position vector.
     * 
     * @return The distance between the points.
     */
    public double distance(Vector3D p) {
        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y) + (this.z - p.z) * (this.z - p.z));
    }
    /**
     * Get the distance of this point's position vector to another point's position vector in a given norm.
     * 
     * @param p
     *        The second point's position vector.
     * 
     * @param norm
     *        The norm in which the distance is calculated (1 -> manhattan, 2 -> euclide, ...)
     * 
     * @return The distance between the points in the given norm.
     */
    public double distance(Vector3D p, int norm) {
        return Math.pow((Math.pow(Math.abs(this.x - p.x), norm) + Math.pow(Math.abs(this.y - p.y), norm) + Math.pow(Math.abs(this.z - p.z), norm)),
                1d / norm);
    }

    /**
     * Change this vector to the new coordinates.
     */
    public void move(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Move a point's position vector in a direction (by a vector) and a distance.
     * 
     * @param p
     *        The direction vector.
     * 
     * @param distance
     *        The distance to move the new vector
     * 
     * @return The new created vector.
     */
    public Vector3D moveTo(Vector3D p, double distance) {
        double d = distance(p);
        double dx = p.x - x;
        double dy = p.y - y;
        double dz = p.z - z;
        double coef = distance / d;
        return new Vector3D(x + dx * coef, y + dy * coef, z + dz * coef);
    }

    /**
     * Get the angle difference of this vector to another vector.
     * 
     * @param vec
     *        The other vector.
     * 
     * @return The angle difference of the two vectors (from 0° to 180°).
     */
    public double getAngleTo(Vector3D vec) {
        double angle = Math.acos(scalar(vec) / (length() * vec.length())) * 180 / Math.PI;
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }

    /**
     * Get the vector from this point to another.
     * 
     * @param vec
     *        The point to which the vector is calculated.
     * 
     * @return The vector from this points position vector to the other point.
     */
    public Vector3D vectorTo(Vector3D vec) {
        return new Vector3D(vec.x - x, vec.y - y, vec.z - z);
    }

    /**
     * Checks whether a point (by its position vector) is in a given range of this point.
     * 
     * @param p
     *        The point that is checked.
     * 
     * @param range
     *        The range used for the check.
     * 
     * @return True if the point is in the range of this point (distance <= range).
     */
    public boolean isInRange(Vector3D p, double range) {
        return p != this && distance(p) <= range;
    }
}