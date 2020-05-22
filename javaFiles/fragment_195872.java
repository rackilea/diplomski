public GameObject(float posX, float posY, float posZ, 
                float rotX, float rotY, float rotZ, 
                float scaleX, float scaleY, float scaleZ) 
{
    this();
    this.position = new Vector3f(0, 0, 0); // 1
    this.startPosition = new Vector3f(posX, posY, posZ); // 2
    this.position = new Vector3f(this.startPosition);  // 3
}