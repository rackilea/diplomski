for (int out = 0; out < nTracesOut; out++) {
    jfloatArray j_stackOut = (jfloatArray)env->GetObjectArrayElement(jstackTracesOut, out);
    jfloatArray j_powerOut = (jfloatArray)env->GetObjectArrayElement(jpowerTracesOut, out);

    float* stackOutCopyBack = (float*)env->GetPrimitiveArrayCritical(j_stackOut, &isCopy);
    float* powerOutCopyBack = (float*)env->GetPrimitiveArrayCritical(j_powerOut, &isCopy);

    for (int s = 0; s < samplesPerTrace; s++) {
      int readIndex = s + (out * samplesPerTrace);
      stackOutCopyBack[s] = stackTracesOut1D[readIndex];
      powerOutCopyBack[s] = powerTracesOut1D[readIndex];
    }

    env->ReleasePrimitiveArrayCritical(j_stackOut, stackOutCopyBack, 0);
    env->ReleasePrimitiveArrayCritical(j_powerOut, powerOutCopyBack, 0);
  }