void ApplyThrust()
   {
      // Get the distance to the target.
      b2Vec2 toTarget = GetTargetPos() - GetBody()->GetWorldCenter();
      toTarget.Normalize();
      b2Vec2 desiredVel = GetMaxSpeed()*toTarget;
      b2Vec2 currentVel = GetBody()->GetLinearVelocity();
      b2Vec2 thrust = desiredVel - currentVel;
      GetBody()->ApplyForceToCenter(GetMaxLinearAcceleration()*thrust);
   }