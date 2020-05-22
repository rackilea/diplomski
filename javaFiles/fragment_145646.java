.method public setMockMode(Lcom/google/android/gms/common/api/GoogleApiClient;Z)Lcom/google/android/gms/common/api/PendingResult;
    # change here 1 -> 2 to allow for another local variable v1
    .locals 2
    .prologue

    new-instance v0, Lcom/google/android/gms/location/internal/zzd$3;

    # add this line: v1 = 0; 0 is 'false'
    const/4 v1, 0x0

    # pass v1, which is set to 'false', instead of p2 containing isMockMode
    invoke-direct {v0, p0, p1, v1}, Lcom/google/android/gms/location/internal/zzd$3;-><init>(Lcom/google/android/gms/location/internal/zzd;Lcom/google/android/gms/common/api/GoogleApiClient;Z)V
    invoke-virtual {p1, v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->zzb(Lcom/google/android/gms/internal/zzlb$zza;)Lcom/google/android/gms/internal/zzlb$zza;
    move-result-object v0
    return-object v0
.end method